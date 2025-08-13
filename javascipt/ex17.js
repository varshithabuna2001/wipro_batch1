const quizData = [
        {
            question: "Which country introduced icecream?",
            options: ["vietnam", "india", "china", "korea"],
            answer: "china"
        },
        {
            question: "Which planet is called the Red Planet?",
            options: ["Venus", "Mars", "Jupiter", "Saturn"],
            answer: "Mars"
        },
        {
            question: "What is the capital of switzerland?",
            options: ["geneva", "zurich", "ben", "rhine"],
            answer: "ben"
        },
        {
            question: "Who is current prime minister of india",
            options: ["rahul gandhi", "Narendra modi", "Amitshah", "Draupathi murmur"],
            answer: "Narendra modi"
        }
    ];

    let currentIndex = 0;
    let score = 0;

    // Load a question
    function loadQuestion() {
        const q = quizData[currentIndex];
        document.getElementById("question").textContent = q.question;

        const optionsDiv = document.getElementById("options");
        optionsDiv.innerHTML = "";

        q.options.forEach(option => {
            const btn = document.createElement("button");
            btn.textContent = option;
            btn.className = "option-btn";
            btn.onclick = () => checkAnswer(option);
            optionsDiv.appendChild(btn);
        });

        document.getElementById("feedback").textContent = "";
        document.getElementById("nextBtn").style.display = "none";
    }

    // Check answer
    function checkAnswer(selected) {
        const correct = quizData[currentIndex].answer;
        const feedback = document.getElementById("feedback");

        if (selected === correct) {
            feedback.textContent = "Correct!";
            score++;
            document.getElementById("score").textContent = score;
        } else {
            feedback.textContent = "Wrong!";
        }

        // Disable all options
        document.querySelectorAll(".option-btn").forEach(btn => btn.disabled = true);
        document.getElementById("nextBtn").style.display = "inline-block";
    }

    // Move to next question
    function nextQuestion() {
        currentIndex++;
        if (currentIndex < quizData.length) {
            loadQuestion();
        } else {
            document.getElementById("quiz-box").innerHTML = `<h3>Quiz Finished!</h3>
                <p>Your final score is: ${score}/${quizData.length}</p>`;
        }
    }

    // Start quiz
    loadQuestion();