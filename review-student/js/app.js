//define global variables for first and second digits of operation
left = 0;
right = 0;
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

/**
 * generates a new problem given an operator symbol
 * @param {String} operatorSymbol string value of the operator for the problem. Should correspond to defined globally defined perators: '+','-','*','/'
 * @returns problem object to be passed in to display method
 */
  function makeProblem(operatorSymbol){
      changeLeftAndRight();
      const problem = {
        //references global operators against the one passed in to apply the correct operation to the current left/right digits
        answer : (operators[operatorSymbol](left, right)),
        opSymbol : operatorSymbol,
        //calls the same operation on random digits between 1-10 to produce possible but incorrect results for the other three choices
        wrong1 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10))),
        wrong2 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10))),
        wrong3 : (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10)))
      }
      //remove duplicates from the array to prevent duplicate wrong answers, and to prevent any wrong selections from matching the right answer
      validatorArr = [problem.answer, problem.wrong1, problem.wrong2, problem.wrong3];
      for (let i = 1; i < validatorArr.length; i++){
        element = validatorArr[i];
        if (validatorArr.indexOf(element) != validatorArr.lastIndexOf(element)){
          element = (operators[operatorSymbol](getRandomNumber(10), getRandomNumber(10)));
        }
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
    screen.innerText = innerText = left + ' ' + opSymbol +  ' ' + right;
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

  /*
  function generateAndDisplayProblem(){
      const left = getRandomNumber(10);
      const right = getRandomNumber(10);
      const answer = left * right;
      problem = document.querySelector('section div');
      problem.innerText = left + ' ' + operator + ' ' + right;
    arr =  [answer, getRandomNumber(81), getRandomNumber(81), getRandomNumber(81)];
    shuffleArray(arr);
    boxes = document.querySelectorAll('li')
        i = 0
        boxes.forEach((element) => {
            element.innerText = arr[i];
            i++;
        })

  } */