const birds = ["1", "2", "3"];

const header = document.querySelector("header");

birds.forEach((b) => {
    const img = document.createElement("img");
    img.src = `/img/${b}.png`; // Absolute path to static/img

    const audio = document.createElement("audio");
    audio.src = `/mp3/${b}.mp3`; // Absolute path to static/mp3

    img.appendChild(audio);

    img.addEventListener("click", () => {
        audio.play();
    });

    header.appendChild(img);
});
