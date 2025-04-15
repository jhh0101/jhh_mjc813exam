let ranNum = 0;
let ranIdxArr = [];
while(ranIdxArr.length < 6){
    ranNum = Math.floor(Math.random() * 45) + 1;
    if(ranIdxArr.indexOf(ranNum) === -1){
        ranIdxArr.push(ranNum);
    }
    ranIdxArr.sort((a, b) => {return a-b});
}
console.log(ranIdxArr);

let line = Number(prompt("숫자 입력"));
let result = "";
for (let i = 1; i < line*2; i+=2) {
  for (let j = 1; j < ((line * 2) - i) / 2 ; j++) {
    result += " ";
  }
  for( let l=1; l<=i;l++){
    result += "*";
  }
  result += "\n";
}
console.log(result);



//let name = prompt("입력하세요");
//function reverseString(str) {
//    return str.split("").reverse().join("");
//}
//console.log(reverseString(name));