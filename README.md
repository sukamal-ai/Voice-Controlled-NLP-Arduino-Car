# A Voice-Controlled (NLP) Arduino Car
<p>The Arduino based Car understands Natural Langauge (Commands to move into different directions)</p>
<a href="https://youtu.be/5IRSK7ewmZM">Check out the working video here</a>
<p>The project is divided into 3 parts</p>
<ol>
<li>  
Natural Language Processing
<ul>
<li>Created a CSV file with all possible commands and action</li>
<li>Text preprocessing (vectorization)</li>
<li>Trained a Decision Tree Classifier</li>
<li>Converted the classifier into Java code using sklearn-porter</li>
  </li>
  </ul>
  <li>
    <ul>
Android Application
<li>The android application converts speech to text</li>
<li>The text is further preprocessed and passed to the model (DT Classifier Java code) for prediction</li>
<li>Send the model output (action) to Arduino via Bluetooth</li>
  </li>
    </ul>
  <li>
    <ul>
Arduino - executes the action
 </ul>
 </li>
</ol>

<img height=400 width=400 src="https://github.com/sukamal1928/Voice-Controlled-NLP-Arduino-Car/blob/master/car.jpeg">
