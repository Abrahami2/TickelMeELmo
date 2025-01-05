#include <Adafruit_NeoPixel.h>

#define LED_PIN 6
#define NUM_LEDS 2
#define SMOKE_PIN 7

Adafruit_NeoPixel strip(NUM_LEDS, LED_PIN, NEO_GRB + NEO_KHZ800);

void setup() {
    Serial.begin(9600);
    strip.begin();
    strip.show();
    pinMode(SMOKE_PIN, OUTPUT);
    digitalWrite(SMOKE_PIN, LOW);
}

void loop() {
    if (Serial.available() > 0) {
        String command = Serial.readStringUntil('\n');
        command.trim();

        if (command == "SMOKE_ON") {
            digitalWrite(SMOKE_PIN, HIGH);
        } else if (command == "SMOKE_OFF") {
            digitalWrite(SMOKE_PIN, LOW);
        } else if (command.startsWith("EYES_")) {
            String color = command.substring(5);
            setEyesColor(color);
        }
    }
}

void setEyesColor(String color) {
    uint32_t rgbColor;

    if (color == "RED") rgbColor = strip.Color(255, 0, 0);
    else if (color == "BLUE") rgbColor = strip.Color(0, 0, 255);
    else rgbColor = strip.Color(0, 0, 0); // OFF

    for (int i = 0; i < NUM_LEDS; i++) {
        strip.setPixelColor(i, rgbColor);
    }
    strip.show();
}
