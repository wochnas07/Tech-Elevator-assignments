// add pageTitle
const pageTitle = "My Shopping List";

// add groceries
let groceries = [
{ id: 1, name: 'Apples', completed: false },
{ id: 2, name: 'Bananas', completed: false },
{ id: 3, name: 'Vodka', completed: false },
{ id: 4, name: 'Cheez-Itz', completed: false },
{ id: 5, name: 'Gogurt', completed: false },
{ id: 6, name: 'Meatballs', completed: false },
{ id: 7, name: 'Pizza Rolls', completed: false },
{ id: 8, name: 'Taquitos', completed: false },
{ id: 9, name: 'White Claws', completed: false },
{ id: 10, name: 'Hot Sauce', completed: false }
];

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
  const ul = document.querySelector('ul');
  groceries.forEach((item) => {
    const li = document.createElement('li');
    li.innerText = item.name;
    const checkCircle = document.createElement('i');
    checkCircle.setAttribute('class', 'far fa-check-circle');
    li.appendChild(checkCircle);
    ul.appendChild(li);
  });
}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {
  const allComplete = document.getElementsByTagName('#')
  let allItemsIncomplete = true;
  allComplete.addEventListener('click', () => 
    {
      if (allItemsIncomplete === true) {
        singleRow.forEach((row) => {
          row.classList.add('completed');
          row.querySelector('i').classList.add('completed'); 
          })
        allItemsIncomplete = false;
        allComplete.innerHTML = "Mark All Incomplete";
      } else {
        singleRow.forEach((row) => {
          row.classList.remove('completed');          
          row.querySelector('i').classList.remove('completed');
      })         
        allItemsIncomplete = true;          
        allComplete.innerHTML = "Mark All Complete"; 
    }        
  })     
}





setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});


