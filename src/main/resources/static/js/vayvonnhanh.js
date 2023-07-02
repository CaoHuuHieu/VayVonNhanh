
function showNavbar(){
	const parent = document.querySelector('.shortcut-1');
	const child = document.querySelector('.show');
	  child.style.display = (child.style.display === 'none') ? 'block' : 'none';
}

function handleKeyDown(event) {
  if (event.keyCode === 13) {
    event.preventDefault();
    var input = document.getElementById("discription");
    input.value += "<br/> \n";
    console.log(input.value, "log");
  }
}
