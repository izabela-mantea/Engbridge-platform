

UAC Service - Setup și Pornire
Cerințe
Python 3.13+
MySQL (oprit pentru development local)
Git
Quick Start
1. Setup inital

# Clone repo
git clone <repo-url>
cd backend/uac-service

# Creeaza mediul virtual
python -m venv venv

# Activeaza mediul virtual
venv\Scripts\activate
2. Instalează dependentele

pip install -r requirements.txt

3. Generează fisierele Protocol Buffers

python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. protos/auth.proto

4. Configurare (optional)
Creează fisierul config/.env dacă ai nevoie de configuratii custom:


DATABASE_URL=mysql+pymysql://user:password@localhost:3306/database_name
JWT_SECRET_KEY=your-secret-key
GRPC_PORT=50051
HTTP_PORT=8000

5. Porneste serverul

python server.py
Serverul va rula pe:

gRPC: localhost:50051
REST API: http://localhost:8000

Troubleshooting

Eroare: ModuleNotFoundError: No module named 'google'

python -m grpc_tools.protoc -I. --python_out=. --grpc_python_out=. protos/auth.proto


Eroare: Pachete lipsa

pip install -r requirements.txt

Eroare: Database connection

Verifica că MySQL rulează
Verifica credentialele în config/.env
Notițe Importante
⚠️ NU edita manual fisierele auth_pb2.py si auth_pb2_grpc.py - sunt generate automat din auth.proto

⚠️ Dacs modifici protos/auth.proto, trebuie sa regenerezi fisierele cu comanda din pasul 3

⚠️ Asigura-te ca folosesti mediul virtual activat (venv\Scripts\activate)

