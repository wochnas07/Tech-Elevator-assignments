/* Define any shared data required by the app 
    Score
     Set of problems
        Each problem has:
                Left-side number for the multiple
                Right-side number
                Current answer
                Set of answers
*/
let score = 0;              // Hold the score for the current set of problems for the user
let setOfProblems = [];     // Hold the set of problems to be presented to the user
let currentProblem = 1;

/* Generate a problem set containing 10 problems                */
function generateProblemSet() {
    for(let i=0; i < 10; i++) {
        /* Randomly generate a single multiplication problem    */
        /* Define a problem to hold the values generated        */
        let problem = {
            left: getRandomNumber(10),       /* should be a random value between 0 and 9     */
            right: getRandomNumber(10),      /* should be a random value between 0 and 9     */
            correctAnswer: null,            /* right now, we don't know the correct answer  */
            setOfAnswers: []
        }
        problem.correctAnswer = problem.left * problem.right;

        /* the set of answers needs to have the correct answer and 3 random other answers   */
        /* randomize/shuffle the elements in the setOfAnswers so the correct answer isn't always first */
        let setOfAnswers = 
            shuffleArray([problem.correctAnswer, getRandomNumber(82), getRandomNumber(82), getRandomNumber(82)]);

        /* Add the problem object and the setAnswers object to the problem set                   */
        setOfProblems.push({problem, setOfAnswers});
    }
}
/* Show the problem to the user                             */
function displayProblem() {             // Add a single problem to the DOM so it displays
    const theProblem = document.getElementById('problem')
        // expression elements (left / right values) are in an element in an array (setOfProblems)
        // left side * right side
    const problemExpression = `${setOfProblems[currentProblem-1].problem.left} * ${setOfProblems[currentProblem-1].problem.right}`;
    // add theProblem expression to the DOM so it displays
    theProblem.querySelector('div.expression').innerText = problemExpression;
}
/* show the answer choices to the user              */
function displayAnswers() {
    const theAnswers    = document.getElementById('answers')
    const listOfAnswers = theAnswers.querySelector('ul')
    const allAnswers    = listOfAnswers.querySelectorAll('li')

        // To make the code easier to read - extract the answer array from the problem
    const answerChoices = setOfProblems[currentProblem-1].setOfAnswers;

    // We have all the list items to hold the answers in an array
    // Go through the array of <li> and assign each one of the answer choices

    for (let i = 0; i < allAnswers.length; i++) {
        allAnswers[i].innerText = answerChoices[i];     // Assign the answerChoice to the corresponding element in the <li>

    }

}

/* Show four randomly generated answers to the problem in a list across the page */
/* determine the correct answer to the problem */
/* include the correct in the four answers displayed to the user */
/* allow user to click on one of the answers displayed */
/* Update the problem count when the user selects an answer */
/* Determine if the answer chosen was correct */
/* update score if answer was correct */
/* Move/change to the next problem when user chooses and answer */
/* Reset when the user wants to start over   */

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

  /* 
  After the DOM has been fully loaded, we want to start displaying and setting up our app
  */
 document.addEventListener('DOMContentLoaded', () => {

    /* add event listeners for <li> tags to make them clickable */
    let answerListItems = document.querySelectorAll('#answers ul li')

    answerListItems.forEach((aListItem), () => {
        aListItem.addEventListener('click', (eventObject) => {
            const answerPicked = parseInt(eventObject.currentTarget.innerText);
            // extract the correct answer for the expression thats being displayed
            const correctAnswer = parseInt(setOfProblems[currentProblem-1].problem.correctAnswer)
            // check their choice against the correct answer with an if statement
            if(answerPicked === correctAnswer) {
                score ++;
            }
    })

     generateProblemSet();      // Generate a problem set
     displayProblem();          // Display a problem
     displayAnswers();
 })
})