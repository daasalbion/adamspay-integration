class Jwt {
    token: string;
    type: string;
    account: string;
    name: string;
    role: string;

}

export type JwtResponse = Jwt | null;

