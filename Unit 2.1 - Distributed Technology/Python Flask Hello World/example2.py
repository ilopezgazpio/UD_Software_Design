from flask import Flask, request
from flask_restful import Resource, Api

app = Flask(__name__)
api = Api(app)

messages = {}

class Messages(Resource):
    def get(self, message_id):
        return {message_id: messages[message_id]}

    def put(self, message_id):
        messages[message_id] = request.form['message']
        return {message_id: messages[message_id]}

api.add_resource(Messages, '/<string:message_id>')

if __name__ == '__main__':
    app.run(debug=True)
