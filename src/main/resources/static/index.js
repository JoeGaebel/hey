const video = document.getElementById('video');

video.addEventListener('click', () => {
    video.play();
});

video.play();

// let req = new XMLHttpRequest();
// req.open('GET', '/video', true);
// req.responseType = 'blob';
//
// req.onload = function() {
//     if (this.status === 200) {
//         let videoBlob = this.response;
//         let vid = URL.createObjectURL(videoBlob);
//         video.src = vid;
//         video.play();
//     }
// };
//
// req.onerror = function() {
//     console.log("wah wah");
// };
//
// req.send();
