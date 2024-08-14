import readline from "readline-sync";
import fs from 'fs';
let name=readline.question("Enter you name: ")
let age=readline.questionInt("Enter age: ")
let mail=readline.questionEMail("Enter mail: ")
let newEmployee={
    name,age,mail
}
console.log(JSON.stringify(newEmployee))
const jsonStr=fs.readFileSync("employee.json").toString()
const jsonData=JSON.parse(jsonStr)
jsonData.push(newEmployee);
console.log(jsonData)
fs.writeFileSync("employee.json",JSON.stringify(jsonData))