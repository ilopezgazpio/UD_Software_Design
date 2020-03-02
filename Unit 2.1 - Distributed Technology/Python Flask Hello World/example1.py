import argparse
from flask import Flask
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

parser = argparse.ArgumentParser(description='Rest microservice tutorial 1')
parser.add_argument('--host', type=str, default="127.0.0.1", help='Local Address in which Restful service will be listening')
parser.add_argument('--port', type=int, default=5000, help='Local port in which Restful service will be listening')
args = parser.parse_args()

class HelloWorld(Resource):
    def get(self):
        return {'hello': 'world'}

api.add_resource(HelloWorld, '/')

if __name__ == '__main__':
    app.run(host=args.host, port=args.port, debug=True)
