#include <EtherCard.h>
static byte mymac[] = {  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
byte Ethernet::buffer[700];

void setup() {
  Serial.begin(9600);
  Serial.println("\n[myServer]");

  if (ether.begin(sizeof Ethernet::buffer, mymac, SS) == 0) 
    Serial.println("Failed to access Ethernet controller");
  
  static byte myip[] = {192,168,1,200}; 
  static byte gwip[] = {192,168,3,1};  
  static byte dnsip[] = {192,168,1,1}; 
  ether.staticSetup(myip, gwip, dnsip);

  ether.printIp("IP: ", ether.myip);
  ether.printIp("GW: ", ether.gwip);
  ether.printIp("DNS: ", ether.dnsip);

  if (!ether.dnsLookup("google.com"))
    Serial.println("DNS failed");
}

void loop() {
  ether.packetLoop(ether.packetReceive());

  word len = ether.packetReceive();
  word pos = ether.packetLoop(len);

  if (len > 0 && pos) {
    
    if (strstr((char *) Ethernet::buffer + pos, "GET /?led=on")) {
      digitalWrite(13, HIGH);
      Serial.println("LED turned ON.");
    } else if (strstr((char *) Ethernet::buffer + pos, "GET /?led=off")) {
      digitalWrite(13, LOW);
      Serial.println("LED turned OFF.");
    }

    const char httpResponse[] PROGMEM = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<h1>Arduino Web Server</h1><a href=\"/?led=on\">Turn On LED</a><br><a href=\"/?led=off\">Turn Off LED</a><br>";
    memcpy(Ethernet::buffer, httpResponse, sizeof(httpResponse));

    ether.httpServerReply(sizeof(httpResponse) - 1);
  }
}
