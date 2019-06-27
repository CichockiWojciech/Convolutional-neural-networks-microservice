import pika

# config
server_exchange = 'server-exchange'
client_exchange = 'client-exchange'
server_queue = 'server-queue-2'
client_queue = 'client-queue-2'
server_key = 'server_key'
client_key = 'client_key'

server_connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='192.168.99.100'))
server_channel = server_connection.channel()

server_channel.queue_declare(queue=server_queue)
server_channel.exchange_declare(exchange=server_exchange, exchange_type='direct', durable=True)
server_channel.queue_bind(queue=server_queue, exchange=server_exchange, routing_key=server_key)


client_connection = pika.BlockingConnection(
    pika.ConnectionParameters(host='192.168.99.100'))
client_channel = client_connection.channel()
client_channel.queue_declare(queue=client_queue)
client_channel.exchange_declare(exchange=client_exchange, exchange_type='direct', durable=True)
client_channel.queue_bind(queue=client_queue, exchange=client_exchange, routing_key=client_key)


def callback(ch, method, properties, body):
    response = body.decode("utf-8")
    # network
    client_channel.basic_publish(exchange=client_exchange, routing_key='', body='Yes/No')


server_channel.basic_consume(
    queue=server_queue, on_message_callback=callback, auto_ack=True)

print('[*] Waiting for messages.')
server_channel.start_consuming()
