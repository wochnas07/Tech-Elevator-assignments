// add pageTitle
const pageTitle = "My Shopping List";

// add groceries
let groceries = ['Apples', 'Bananas', 'Vodka', 'Cheez-Its', 'Gogurt', 'Meatballs', 'Pizza Rolls', 'Taquitos', 'White Claws', 'Hot Sauce']


/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
  const thePageTitle = document.getElementById('title');
  thePageTitle.innerText = pageTitle;
}


/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
  const theUl = document.getElementById('groceries');

  groceries.forEach((theGroceries) => {

    const newGrocery = document.createElement('li');

    newGrocery.setAttribute('class', 'item')
  })
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});


