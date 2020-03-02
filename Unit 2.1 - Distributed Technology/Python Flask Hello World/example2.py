import argparse
from flask import Flask, request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

parser = argparse.ArgumentParser(description='Rest microservice tutorial 2')
parser.add_argument('--host', type=str, default="127.0.0.1", help='Local Address in which Restful service will be listening')
parser.add_argument('--port', type=int, default=5000, help='Local port in which Restful service will be listening')
args = parser.parse_args()

messages = {}

class Messages(Resource):
    def get(self, message_id):
        return {message_id: messages[message_id]}

    def put(self, message_id):
        messages[message_id] = request.form['message']
        return {message_id: messages[message_id]}

api.add_resource(Messages, '/<string:message_id>')

if __name__ == '__main__':
    app.run(host=args.host, port=args.port, debug=True)
