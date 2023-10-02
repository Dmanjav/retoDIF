from flask_login import UserMixin


class User(UserMixin):
    '''Class for login users storage'''

    def __init__(self, user, password) -> None:
        self.id = user
        self.password = password
