
//로또 만들기
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

//별찍기
let line = Number(prompt("별 숫자 입력"));
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

//let nSpace = 4;
//let nStar = 1;
//for(let nLine = 0; nLine<5; nLine++){
//    let strLine = "";
//    for(let nSp = 0; nSp < nSpace; nSp++){
//        strLine += " ";
//    }
//    for(let nSt = 0; nSt < nStar; nSt++){
//        strLine += "*";
//    }
//    console.log(strLine);
//    nSpace--;
//    nStar += 2;
//}


//게임 캐릭터 클래스 만들기
class Wizard{
    health = 0;
    mana = 0;
    armor = 0;
    constructor(h, m, a){
        this.health = h;
        this.mana = m;
        this.armor = a;
    }
    attack(){
        console.log("파이어볼");
    }
}

const x= new Wizard(545, 210, 10);
console.log(x.health, x.mana, x.armor);
x.attack();


//거꾸로
let name = prompt("거꾸로 문자 입력");
function reverseString(str) {
    return str.split("").reverse().join("");
}
console.log(reverseString(name));