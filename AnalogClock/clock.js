const hourHand = document.querySelector("#hour");
const minHand = document.querySelector("#minute");
const secHand = document.querySelector("#second");

var currDate = new Date();
let hr = currDate.getHours();
let min = currDate.getMinutes();
let sec = currDate.getSeconds();
var hr24 = hr;
hr = (hr>12)? hr-12: hr;

// console.log(`${hr}:${min}:${sec}`);

let hrPosition = (360/12 * hr);
let minPosition = 360/60 * min;
let secPosition = 360/60 * sec;
hrPosition += minPosition/12;
minPosition += secPosition/60; //minite movement for second hand

function runTheClock() {
    
    //position change in per second
    hrPosition += (360/(3600*12));
    minPosition += (360/3600);
    secPosition += 6;
    
    // hourHand.setAttribute("style", `transform: rotate(${hrPosition}deg)`);
    hourHand.style.transform = `rotate(${hrPosition}deg)`;
    minHand.setAttribute("style", `transform: rotate(${minPosition}deg)`);
    secHand.style.transform = `rotate(${secPosition}deg)`;
    
    var currDate = new Date();
    let hr = currDate.getHours().toString().padStart(2, "0");
    let min = currDate.getMinutes().toString().padStart(2, "0");
    let sec = currDate.getSeconds().toString().padStart(2, "0");
    document.querySelector(".digital-clock").innerText = `${hr}:${min}:${sec}`

}

setInterval(runTheClock, 1000);
