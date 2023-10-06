from flask_login import UserMixin


class Admin_user(UserMixin):
    '''Class for login users storage'''

    def __init__(self, user, password) -> None:
        self.id = user
        self.password = password
