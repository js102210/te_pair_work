operator = '*';


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

  }