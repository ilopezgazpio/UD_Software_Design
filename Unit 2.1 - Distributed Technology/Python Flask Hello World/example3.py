from flask import Flask
from flask_restful import reqparse, abort, Api, Resource

app = Flask(__name__)
api = Api(app)

MESSAGES = {
    'message1': {'message1_1': 'message1_1-content'},
    'message2': {'message2_1': 'message2_1-content'},
    'message3': {'message3_1': 'message3_1-content'},
}


def abort_if(message_id):
    if message_id not in MESSAGES:
        abort(404, message="Message {} doesn't exist".format(message_id))

parser = reqparse.RequestParser()
parser.add_argument('message', type=str, help= "Message id")

# shows a single message item and lets you delete a message item
class Message(Resource):
    
    def get(self, message_id):
        abort_if(message_id)
        return MESSAGES[message_id]

    def delete(self, message_id):
        abort_if(message_id)
        del MESSAGES[message_id]
        return '', 204

    def put(self, message_id):
        args = parser.parse_args()
        message = {'message': args['message']}
        MESSAGES[message_id] = message
        return message, 201


# shows a list of all todos, and lets you POST to add new tasks
class MessageList(Resource):
    def get(self):
        return MESSAGES

    def post(self):
        args = parser.parse_args()
        message_id = int(max(MESSAGES.keys()).lstrip('message')) + 1
        message_id = 'message%i' % message_id
        MESSAGES[message_id] = {'message': args['message']}
        return MESSAGES[message_id], 201

## Actually setup the Api resource routing here
api.add_resource(MessageList, '/messages')
api.add_resource(Message, '/messages/<message_id>')


if __name__ == '__main__':
    app.run(debug=True)
