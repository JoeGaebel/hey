const video = document.getElementById('video');

video.play();

video.addEventListener('click', () => {
    video.play();
});