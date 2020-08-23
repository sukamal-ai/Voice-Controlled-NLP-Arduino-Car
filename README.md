# Voice Controlled (NLP) Arduino Car

<p> A voice controlled Arduino Car</p> 
<p> The Car understands Natural Langauge (Commands to move into different directions) </p>

<p><a href="https://youtu.be/5IRSK7ewmZM">Check out the working video here</a></p>

<p> The project is divided into 3 parts </p>

<ol>
  
  <li>Natural Language Processing
     <ul>
       <li>Created a CSV file with all possible commands and action</li>
       <li>Text preprosessing (vectorization)</li>
       <li>Trained a Decision Tree Classifier</li>
       <li>Converted the classifier into Java code using sklearn-porter</li> 
     </ul>
  </li>
    
  <li>Android Application
      <ul>
       <li>Android application converts speech to text</li>
       <li>The text is further preprocessed and passed to the model (DT Classifier Java code) for prediction</li>
       <li>Send the model output (action) to Arduino via bluetooth</li> 
     </ul>
  </li>
  
  <li>Arduino - executes the action</li>
  
</ol>

