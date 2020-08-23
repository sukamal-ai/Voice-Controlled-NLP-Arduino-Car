
//motor 1
int inA1 = 6;
int inA2 = 7;
int enA = 5;

//motor 2
int inB1 = 12;
int inB2 = 13;
int enB = 9;

//motor 3
int inC1 = 4;
int inC2 = 8;
int enC = 11;

//motor 4
int inD1 = 3;
int inD2 = 2;
int enD = 10;


void setup(){

  Serial.begin(9600); 
  
  pinMode(enA, OUTPUT);
  pinMode(inA1, OUTPUT);
  pinMode(inA2, OUTPUT);

  pinMode(enB, OUTPUT);
  pinMode(inB1, OUTPUT);
  pinMode(inB2, OUTPUT);

  pinMode(enC, OUTPUT);
  pinMode(inC1, OUTPUT);
  pinMode(inC2, OUTPUT);

  pinMode(enD, OUTPUT);
  pinMode(inD1, OUTPUT);
  pinMode(inD2, OUTPUT);
}

void stop_car(){
  digitalWrite(inA1, LOW);
  digitalWrite(inA2, LOW);

  digitalWrite(inB1, LOW);
  digitalWrite(inB2, LOW);

  digitalWrite(inC1, LOW);
  digitalWrite(inC2, LOW);

  digitalWrite(inD1, LOW);
  digitalWrite(inD2, LOW);
}

void fast_reverse(){
  analogWrite(enA, 255);
  analogWrite(enB, 255);
  analogWrite(enC, 255);
  analogWrite(enD, 255);

  digitalWrite(inA1, LOW);
  digitalWrite(inA2, HIGH);

  digitalWrite(inB1, LOW);
  digitalWrite(inB2, HIGH);

  digitalWrite(inC1, LOW);
  digitalWrite(inC2, HIGH);

  digitalWrite(inD1, LOW);
  digitalWrite(inD2, HIGH);
//  
}

void slow_reverse(){
  analogWrite(enA, 150);
  analogWrite(enB, 150);
  analogWrite(enC, 150);
  analogWrite(enD, 150);

  digitalWrite(inA1, LOW);
  digitalWrite(inA2, HIGH);

  digitalWrite(inB1, LOW);
  digitalWrite(inB2, HIGH);

  digitalWrite(inC1, LOW);
  digitalWrite(inC2, HIGH);

  digitalWrite(inD1, LOW);
  digitalWrite(inD2, HIGH);
//  
}

void fast_forward(){
  analogWrite(enA, 255);
  analogWrite(enB, 255);
  analogWrite(enC, 255);
  analogWrite(enD, 255);

  digitalWrite(inA1, HIGH);
  digitalWrite(inA2, LOW);

  digitalWrite(inB1, HIGH);
  digitalWrite(inB2, LOW);

  digitalWrite(inC1, HIGH);
  digitalWrite(inC2, LOW);

  digitalWrite(inD1, HIGH);
  digitalWrite(inD2, LOW);
//  
}

void slow_forward(){
  analogWrite(enA, 150);
  analogWrite(enB, 150);
  analogWrite(enC, 150);
  analogWrite(enD, 150);

  digitalWrite(inA1, HIGH);
  digitalWrite(inA2, LOW);

  digitalWrite(inB1, HIGH);
  digitalWrite(inB2, LOW);

  digitalWrite(inC1, HIGH);
  digitalWrite(inC2, LOW);

  digitalWrite(inD1, HIGH);
  digitalWrite(inD2, LOW);
  
}


void right(){
  analogWrite(enA, 255);
  analogWrite(enD, 255);

  digitalWrite(inA1, LOW);
  digitalWrite(inA2, LOW);

  digitalWrite(inB1, HIGH);
  digitalWrite(inB2, LOW);

  digitalWrite(inC1, HIGH);
  digitalWrite(inC2, LOW);

  digitalWrite(inD1, LOW);
  digitalWrite(inD2, LOW);
  
}

void left(){
 
  analogWrite(enB, 255);
  analogWrite(enC, 255);
 

  digitalWrite(inA1, HIGH);
  digitalWrite(inA2, LOW);

  digitalWrite(inB1, LOW);
  digitalWrite(inB2, LOW);

  digitalWrite(inC1, LOW);
  digitalWrite(inC2, LOW);

  digitalWrite(inD1, HIGH);
  digitalWrite(inD2, LOW);

 
  
}

void loop(){
  if(Serial.available() > 0)  
  {
    char input = Serial.read();

      if (input == 'a'){
        fast_forward();
      }else if (input == 'b'){
        slow_forward();
      }else if(input == 'c'){
        fast_reverse();
      }else if(input == 'd'){
        slow_reverse();
      }else if(input == 'e'){
        right();
      }else if(input == 'f'){
        left();
      }else if(input == 'g'){
        stop_car();
      }else{
        stop_car();
      }
    
  }

          
     
}


  
