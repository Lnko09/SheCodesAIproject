document.getElementById("ai-form").addEventListener("submit", async function(event) {
    event.preventDefault();
    
    const category = document.getElementById("category").value;
    const instructions = document.getElementById("instructions").value;
    const outputDiv = document.getElementById("output");
    outputDiv.innerHTML = "Generating...";
    
    try {
        const response = await fetch("https://api.openai.com/v1/completions", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer 8ebde42a79fb6f1t0802633c6fo94685"
            },
            body: JSON.stringify({
                model: "text-davinci-003",
                prompt: `Generate a ${category} based on these instructions: ${instructions}`,
                max_tokens: 100
            })
        });
        
        const data = await response.json();
        outputDiv.innerHTML = data.choices[0].text;
    } catch (error) {
        outputDiv.innerHTML = "Error generating content. Please try again.";
        console.error(error);
    }
});
