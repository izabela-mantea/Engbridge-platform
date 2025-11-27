# createDB.py
from config.database import Base, engine
from models.user import User
from models.invalid_token import InvalidToken

Base.metadata.create_all(bind=engine)
print("Database tables created!")
