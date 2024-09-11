import {app,db} from "./firebase-config.js";
import { collection, addDoc } from "https://www.gstatic.com/firebasejs/9.12.1/firebase-firestore.js"; 
//  const app = initializeApp(firebaseConfig);
//  const db = getFirestore(app);

var name=document.getElementById("name");
var email=document.getElementById("email");
var subject=document.getElementById("subject");
var message=document.getElementById("message");
var submit=document.getElementById("submit");


async function addDataa(){
    try {
        let collectionRef=collection(db, "contactus")
      const docRef = await addDoc(collectionRef, {
        name:name.value,
        email:email.value,
        subject:subject.value,
        // message:message.value


      });
      console.log("Document written with ID: ", docRef.id);

      alert("The message is saved");

    } catch (e) {
      console.error("Error adding document: ", e);
      alert("Your message is not saved");
console.log(e);
    }
}

if(submit){
    submit.addEventListener("click",addDataa)
}