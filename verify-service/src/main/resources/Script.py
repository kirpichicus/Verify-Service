import sys
from mypackage.process import processing
import pickle

if __name__== "__main__":
  main(sys.argv)

def main(argv):
    modelPath = argv[2]
    message = argv[1]
    loaded_model = pickle.load(open(modelPath, 'rb'))
    message_vector = processing(message)
    result = loaded_model.predict(message_vector)
    print(result)