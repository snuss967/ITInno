#Retreive Scale Data
def rscale():


#Retreive RFID Data
def rrfid():
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)

GPIO.setup(21, GPIO.IN) #data 0
GPIO.setup(22, GPIO.IN) #data 1
r = 1
bit = 0
d0 = 0
d1 = 0

def rmain():
   global bit
   global r
   global d0
   global d1
   while True:
      d0 = GPIO.input(21)
      d1 = GPIO.input(22)
      if d0 == False or d1 == False:
        if d0 == False and d1 == True:
                bit = 0
        if d0 == True and d1 == False:
                bit = 1
        print "Bit %s: %s" % (r,bit)
        r = r + 1


if __name__ == '__main__':
   rmain()

