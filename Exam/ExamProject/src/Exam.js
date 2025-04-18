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

class Exam19{
    square(){
        let number = prompt("숫자를 두개 입력해주세요");
        let squareNum = number.split(" ");
        let a = Number(squareNum[0]);
        let b = Number(squareNum[1]);
        let result = 1;
        for(let i=1; i<=b; i++){
            result *= a;
        }
        console.log(result);
    }
}
let exam19 = new Exam19();
//exam19.square();

class Exam25{

    pi(){
        let number = Number(prompt("원의 반지름 입력"));
        let result = number * number * 3.14;
        console.log(result);
    }
}
let exam25 = new Exam25();
//exam25.pi();

//class Exam25{
//    result;
//    constructor(p){
//        this.result = p;
//    }
//
//    pi(){
//        return this.result * this.result * 3.14;
//    }
//}
//let exam25 = new Exam25(3);
//let result=exam25.pi();
//console.log(result);


class Exam26{
    planet(){
        let planetName = prompt("행성 이름 입력");
        switch(planetName) {
            case "수성":
            console.log("Mercury");
            break;
            case "금성":
            console.log("Venus");
            break;
            case "지구":
            console.log("Earth");
            break;
            case "화성":
            console.log("Mars");
            break;
            case "목성":
            console.log("Jupiter");
            break;
            case "토성":
            console.log("Saturn");
            break;
            case "천왕성":
            console.log("Uranus");
            break;
            case "해왕성":
            console.log("Neptune");
            break;
        }
    }
}
let exam26 = new Exam26();
//exam26.planet();

class Exam27{
    maps = new Map;
    inputFunc(){
        let names = prompt("이름을 공백으로 구분하여 입력하세요");
        let score = prompt("점수를 공백으로 구분하여 입력하세요");
        let arrName = names.split(" ");
        let arrScore = score.split(" ");
        for(let i = 0; i < arrName.length; i++){
            this.maps.set(arrName[i], Number(arrScore[i]));
        }
        if(arrName.length != arrScore.length){
            alert("다시 입력하세요");
            return false;
        }
        console.log(this.maps);
        return true;
    }
    outputFunc(){
        let strOutput = "";
        for(let item of this.maps){
            strOutput += `'${item[0]}': ${item[1]}, `
        }
        strOutput = strOutput.substring(0, strOutput.length -2);
        console.log('{'+strOutput+'}');
    }
}
let exam27 = new Exam27();
//if ( exam27.inputFunc() ) {   // inputFunc() 를 실행하고 리턴값이 true 이면
//    exam27.outputFunc();  // outputFunc() 를 실행한다.
//}

class Exam28{
    strInput = "";
    constructor(str){
        this.strInput = str;
    }
    Output(){
        let strOutput = this.strInput;
        for(let i = 0; i < strOutput.length-1; i++){
            console.log(`${strOutput[i]} ${strOutput[i+1]}`);
        }
    }
}
//let exam28 = new Exam28(prompt("문자열을 입력하세요"));
//exam28.Output();

class Exam37 {
    arrItem = [];
    maps = new Map();
    constructor(input) {
        this.arrItem = input.split(" ");
    }
    checkVotes() {
        // 배열에 루프를 실행하여 검색해본다.
        for( let i = 0; i < this.arrItem.length; i++ ) {
            if ( this.isExistItem(this.arrItem[i]) ) {
                // map 에 원소이름의 키가 있을때 실행한다.
                let number = this.maps.get(this.arrItem[i]);
                // map 에서 원소이름이 키인 원래값을 가져온다.
                this.maps.set(this.arrItem[i], number + 1);
                // map 에 {원소이름: 원래값+1} 으로 저장 한다
                // this.maps.set( 키, 값 );
            } else {
                // map 에 원소이름의 키가 없을때 실행한다.
                this.maps.set(this.arrItem[i], 1);
                // map 에 {원소이름: 1} 으로 저장 한다
                // this.maps.set( 키, 값 );
            }
        }
        console.log(this.maps);
        console.log([...this.maps]);    // [... JavaScript Map, Set, Array] ===> 배열로 변환
        let item = Array.from(this.maps).reduce( (a,b) =>  // Array reduce 사용
            a[1] >= b[1] ? a : b    // 앞의 원소 a[1] 값 >= 뒤의 원소 b[1] 값 보다 크면 a 를 리턴
        );
        return item;
        // return 가장 [1] 값이 큰 map 원소를 리턴한다.
    }
    isExistItem(item) {
        // 원소가 maps 에 키로 존재하면 true 를 리턴한다.
        return this.maps.has(item);
        // if ( this.maps.has(item) == true )
    }
}
// 원범 혜원 유빈 원범 혜원 곰 유빈 원범 곰 혜원 호랑이 혜원
//let exam37 = new Exam37(prompt("투표할 항목을 공백으로 구분해서 입력하세요."));
//let result = exam37.checkVotes();
//console.log(`투표 결과 ${result[0]}가 ${result[1]}표로 가장 많습니다.`);

class Exam40{
    weight(){
        let w1 = prompt("제한 무게 입력");
        let newW1 = Number(w1);

        let num1 = prompt("친구들 수 입력");
        let newNum1 = Number(num1);

        let w2 = prompt("친구들 몸무게 입력(공백으로)");


        let arr = w2.split(" ").map((x) => Number(x));


        let result = 0;
        let num2 = 0;
        for(let i = 0; i < newNum1; i++){
            if(newW1 < arr[i] + result){
                return num2;
            }
            num2 += 1;
            result += arr[i];
        }


    }
}
let exam40 = new Exam40();
//let count = exam40.weight();
//console.log(count);

class Exam41{
    num(){
        let number = prompt("숫자 입력");
        let number1 = Number(number);
        let answer = "";
        if(number1 == 2 || number1 == 1){
            answer = "Yes";
        }
        for(let i = 2; i < number1; i++){
            if(number1 % i == 0){
                answer = "No";
                break;
            }
            else {
                answer = "Yes";
            }
        }
        console.log(answer);
    }
}
let exam41 = new Exam41();
//exam41.num();

class Exam42{
    day(){
        let month = prompt("월 입력");
        let date = prompt("일 입력");
        let d = new Date(`2020-${month}-${date}`);
        let str = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
        console.log(str[d.getDay()]);
    }
}
let exam42 = new Exam42();
exam42.day();