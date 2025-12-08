from pydantic  import BaseSettings
from functools import lru_cache
import os

class Settings(BaseSettings):
    mysql_host: str = "localhost"
    mysql_port: int = 3306
    mysql_database: str = "Users"
    mysql_user: str = ""
    mysql_password: str = ""
    jwt_secret: str = "default-secret-change-me"  
   
    class Config: #type: ignore
        env_file = os.path.join(os.path.dirname(__file__), "..", ".env")
        case_sensitive = False
        extra = "allow"

    @property
    def database_url(self) -> str:
        return f"mysql+pymysql://{self.mysql_user}:{self.mysql_password}@{self.mysql_host}:{self.mysql_port}/{self.mysql_database}"

@lru_cache()
def get_settings():
    return Settings()