from sqlalchemy import Column,Integer,String,Boolean
from config.database import Base

class InvalidToken(Base):
    __tablename__ = "invalid_tokens"

    id = Column(Integer, primary_key=True, index=True)
    token = Column(String(255), unique=True)