const testWrapper = document.querySelector(".test-wrapper");
const textArea = document.querySelector("#test-area");
const originText = document.querySelector("#origin-text p").innerHTML;
const resetButton = document.querySelector("#reset");
const theTimer = document.querySelector(".timer");
const resultArea = document.querySelector(".wpm");

var timer = [0, 0, 0, 0]; //[hr, min, sec, sec/10]
var interval;

// Add leading zero to numbers 9 or below (purely for aesthetics):
function addLeadingZero(num){
    return num.toString().padStart(2, "0");
}
// calculate word per minute
function getWordPerMin(givenText, totalTime) {
    var totalMin = totalTime[0]*60 + totalTime[1] + totalTime[2]/60;
    var noOfWords = getNoOfWords(givenText);
    return Math.floor(noOfWords/totalMin);
}

function getNoOfWords(text) {
    text = text.trim();
    var space=0;
    for(let i=0; i<text.length; i++){
        if(text[i]===' ') space++;
    }
    return space+1;
}


// Run a standard minute/second/hundredths timer:
function runTimer() {
    let currentTime = timer[0].toString().padStart(2, "0")+":"+
                    timer[1].toString().padStart(2, "0") + ":"+
                    timer[2].toString().padStart(2, "0") + ":"+
                    timer[3].toString().padStart(2, "0");
    
    theTimer.innerHTML = currentTime;
    timer[3]++;
    if(timer[3]>=100){
        timer[2]++;
        timer[3]=0;
    }
    if(timer[2]>=60){
        timer[1]++;
        timer[2]=0;
    }
    if(timer[1]>=60){
        timer[0]++;
        timer[1]=0;
    }
    
    
}

// Match the text entered with the provided text on the page:
function matchText() {
    let enteredText = textArea.value;
    let len = enteredText.length;
    // console.log(originText.substr(0, len));
    if(enteredText===originText) {
        testWrapper.style.borderColor = "green";
        clearInterval(interval);
        console.log(timer);
        var wpm = getWordPerMin(originText, timer);
        resultArea.innerHTML = "Speed : " + wpm + " wpm"
    }
    else if(originText.substr(0, len) === enteredText)
        testWrapper.style.borderColor = "skyblue";
    else 
        testWrapper.style.borderColor = "red";
}



var timerRunning=false;
// Start the timer:
function startTimer() {
    let textEnteredLength = textArea.value.length;
    if (textEnteredLength===0 && !timerRunning) {
        interval = setInterval(runTimer, 10);
        timerRunning=true;
    }
    // console.log(textEnteredLength+1);
}

// Reset everything:
function reset() {
    testWrapper.style.borderColor = "grey";
    textArea.value = "";
    timer = [0,0,0,0];
    clearInterval(interval);
    interval=null;
    theTimer.innerHTML = "00:00:00:00";
    timerRunning = false;
}

// Event listeners for keyboard input and the reset button:
textArea.addEventListener("keypress", startTimer, false);
textArea.addEventListener("keyup", matchText, false);
resetButton.addEventListener("click", reset, false);

