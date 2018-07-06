import socket
import ssl


def main():
	sock = socket.socket()

	sock.bind(("", 80))
	sock.accept()

	while True:
		print(sock.recv(4096))

if __name__ == "__main__":
	main()