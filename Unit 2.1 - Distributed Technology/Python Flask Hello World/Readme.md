# Flask-Restful examples

## Example 1
```
python3 example1.py
```

Access the resource with
```
curl http://IP:5000/
```

## Example 2
```
python3.6 example2.py
```

```
curl http://IP:5000/todo1 -d "message=message1" -X PUT
curl http://IP:5000/todo1
```

Accessible also through CLI, if requests packet is installed

```
from requests import put, get
>>> put('http://IP:5000/todo1', data={'message': 'Message1'}).json()
{u'todo1': u'Message1'}
>>> get('http://IP:5000/todo1').json()
{u'todo1': u'Message1'}
>>> put('http://IP:5000/todo2', data={'message': 'Message2'}).json()
{u'todo2': u'Message2'}
>>> get('http://IP:5000/todo2').json()
{u'todo2': u'Message2'}
```

## Example 3
```
python3 example3.py
```
```
curl http://IP:5000/messages
curl http://IP:5000/messages/message1
curl http://IP:5000/messages/message3 -X DELETE -v
curl http://IP:5000/messages -d "message=new message" -X POST -v
curl http://IP:5000/messages/message3 -d "message=new but different message" -X PUT -v
```
