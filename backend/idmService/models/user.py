
from sqlalchemy import Column,Integer,String,Boolean
from config.database import Base

class User(Base):
    __tablename__ = "users"
    
    id = Column(Integer, primary_key=True, index=True)
    username = Column(String(50), unique=True, index=True)
    email = Column(String(50), unique=True, index=True)
    password_hash = Column(String(255))
    role = Column(String(50))   

