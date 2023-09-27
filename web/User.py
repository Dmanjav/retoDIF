from flask_login import UserMixin

class User(UserMixin):
    def __init__(self, user, password) -> None:
        self.id = user
        self.password = password