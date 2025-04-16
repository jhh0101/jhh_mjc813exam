class Lotto{
//로또 만들기
    ranLotto(){
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
    }
}
const lotto = new Lotto();
//lotto.ranLotto();

class Star{
    star1(){
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
    }
    star2(){
        let nSpace = 4;
        let nStar = 1;
        for(let nLine = 0; nLine<5; nLine++){
            let strLine = "";
            for(let nSp = 0; nSp < nSpace; nSp++){
                strLine += " ";
            }
            for(let nSt = 0; nSt < nStar; nSt++){
                strLine += "*";
            }
            console.log(strLine);
            nSpace--;
            nStar += 2;
        }
    }
}
const star = new Star();
//star.star1();
//star.star2();



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
//console.log(x.health, x.mana, x.armor);
//x.attack();

class Stars{
    stars(){
        let num = Number(prompt("행성 숫자 입력"));
        let star = ["수성", "금성", "지구", "화성", "목성", "토성", "천왕성", "해왕성", ];
        if(Number.isNaN(num) || num < 1 || num > 9){
            console.log("숫자를 1~8중 하나만 입력하세요");
        }else{
            console.log(star[num-1]);
        }
    }
}
const stars = new Stars();
//stars.stars();

class Revers{
    revers(){
        //거꾸로
        let name = prompt("거꾸로 문자 입력");
        function reverseString(str) {
            return str.split("").reverse().join("");
        }
        console.log(reverseString(name));
    }
}
const revers = new Revers();
//revers.revers();

class Exam0415{
  exam17(){
      let weight = Number(prompt("키를 입력하세요."));
      if(weight >= 150){
          console.log("Yes");
      }else{
          console.log("No");
      }
  }
    exam18(){
        let number = prompt("과목 점수 3개 입력(띄어쓰기)");
        let arr = number.split(" ");
        let avg = 0;
        for(let i=0; i<3; i++){
            avg += Number(arr[i]);
        }
        avg = avg / 3;
        console.log(Math.floor(avg));
    }
}
let exam0415 = new Exam0415();
//exam0415.exam17();
//exam0415.exam18();

class Exam0416{


}
let exam0416 = new Exam0416();
exam0416.exam