let req = new XMLHttpRequest();
req.open('GET', '/video', true);
req.responseType = 'blob';

req.onload = function () {
    if (this.status === 200) {
        const videoBlob = this.response;
        const vid = URL.createObjectURL(videoBlob);
        const video = document.getElementById('video');

        video.addEventListener('click', () => { video.play(); });
        video.src = vid;
        video.play();
    }
};

req.onerror = function () {
    console.log("wah wah");
};

req.send();