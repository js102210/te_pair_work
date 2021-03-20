//define global variables for first and second digits of operation
left = 0;
right = 0;


//currentOperator = '*';
let problemSet = [];
//define types of operations and what they should return for the two digits
const operators = {
    '+' : function (a, b) {return a + b},
    '-' : function (a, b) {return a - b},
    '*' : function (a, b) {return a * b},
    '/' : function (a, b) {return a / b}
}
/**
 * Utility function to generate a random number based on max
 * @param {number} max
 */
 function getRandomNumber(max) {
    return Math.floor(Math.random() * Math.floor(max));
  }

  /**
 * Utility function to shuffle the items in an array
 * @param {object} arr
 */
function shuffleArray(arr) {
    return arr.sort(function (a, b) { return Math.random() - 0.5 })
  }

  //randomly redefines left and right digits of each problem in order to generate a new one
  function changeLeftAndRight(){
    left = getRandomNumber(10);
    right = getRandomNumber(10);
  }

/**check for duplicates in an array
 * 
 * @param {array} arr 
 * @returns true if the array has duplicates, false if not
 */
  function containsDupes(arr){
    result = false;
    arr.forEach((element) => {
      if (arr.indexOf(element) != arr.lastIndexOf(element)){
        result = true;
      }
    });
    return result;
  }

  /**turn the answer properties of a problem object into an array so we can check for duplicates
   * 
   * @param {problem object} problem 
   * @returns an array containing the problem's answer properties, starting with the correct answer, then the three wrong ones
   */
  function makeProblemArr(problem){
    return [problem.answer, problem.wrong1, problem.wrong2, problem.wrong3];
  }

  /**randomizes the wrong answers in a problem object to another possible value ('possible' being determined by the problem's operator)
   * 
   * @param {problem object} problem 
   * @param {operator for the problem object ('+','-','/','*') operatorSymbol 
   */
  function rerollWrongs(problem, operatorSymbol){
    problem.wrong1 = operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10));
    problem.wrong2 = operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10));
    problem.wrong3 = operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10));
  }


/**
 * generates a new problem given an operator symbol
 * @param {String} operatorSymbol string value of the operator for the problem. Should correspond to defined globally defined perators: '+','-','*','/'
 * @returns problem object to be passed in to display method
 */
  function makeProblem(operatorSymbol){
      changeLeftAndRight();
      const problem = {
        //references global operators against the one passed in to apply the correct operation to the current left/right digits
        leftOperand : left,
        rightOperand : right,
        answer : (operators[operatorSymbol](left, right)),
        opSymbol : operatorSymbol,
        //calls the same operation on random digits between 1-10 to produce possible but incorrect results for the other three choices
        wrong1 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10))),
        wrong2 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10))),
        wrong3 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10)))
      }
      //remove duplicates from the array to prevent duplicate wrong answers, and to prevent any wrong selections from matching the right answer
      let validatorArr = makeProblemArr(problem);
      while(containsDupes(validatorArr)){
        rerollWrongs(problem, operatorSymbol);
        validatorArr = makeProblemArr(problem);
      }
      
      return problem;
  }



/**
 * displays the current problem on the screen, along with the possible answers
 * @param {*} problem 
 */
  function displayProblem(problem){
    /*left = problem.left;
    right = problem.right; */
    answer = problem.answer;
    opSymbol = problem.opSymbol;
    screen =  document.querySelector('section div');
    screen.innerText = innerText = problem.leftOperand + ' ' + opSymbol +  ' ' + problem.rightOperand;
    arr =  [problem.answer, problem.wrong1, problem.wrong2, problem.wrong3];
    shuffleArray(arr);
    i = 0;
    boxes = document.querySelectorAll('li')
        i = 0
        boxes.forEach((element) => {
            element.innerText = arr[i];
            i++;
        })
  }

  /**create a set of ten problems
   * currently hard-coded for them all to be multiplication
   */
function createProblemSet(){
 i = 1;
 while (i <=10 ){
   problem = makeProblem('*');  //@TODO come back to this
   problemSet.push(problem);
   i++;
 }
}

function clearProblemSet(){
  problemSet.forEach((element) => {
    problemSet.remove(element);
  })
}

function getCurrentlySelectedProblem(){
  return document.querySelector('.currentProblem').innerText;
}
function getCurrentScore(){
  return document.querySelector('.currentScore').innerText;
}

function showFirstProblem(){
  displayProblem(problemSet[0]);
}

function showNextProblemInSet(){
  //determine current problem based on value in html element
  let currentProblem = getCurrentlySelectedProblem();
  nextProblem = parseInt(currentProblem) + 1;
  //reference the global problemSet to get and display the next problem
  displayProblem(problemSet[currentProblem]);
  document.querySelector('.currentProblem').innerText = nextProblem;
}

function evaluateAnswer(event){
  problemObject = problemSet[getCurrentlySelectedProblem()-1];
  let score = getCurrentScore();
  //nextScore = parseInt(score) + 1;
 // valSelected =  parseInt(event.target.innerText)
 // valCorrect = problemObject.answer
  isRight = (parseInt(event.target.innerText) == problemObject.answer);
  if (isRight){
   document.querySelector('.currentScore').innerText = parseInt(score) + 1;
  }
  showNextProblemInSet();

}



document.addEventListener('DOMContentLoaded', () => {

createProblemSet();
showFirstProblem();
const displayedChoices = document.querySelectorAll('#answers li');
displayedChoices.forEach((element) => {
  element.addEventListener('click', (event) => evaluateAnswer(event))
})



})