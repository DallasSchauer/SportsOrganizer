package sportOrganizer;

public class Tournament extends Event {
    protected int type; // 0 = single elim, 1 = double elim, 2 = round robin
    protected Node head;
    protected Team champion;

    Tournament (String name, String sport, int maxTeams, int age, int type) {
        this.name = name;
        this.sport = sport;
        this.maxTeams = maxTeams;
        this.age = age;
        this.type = type;

        participants = new Team[maxTeams];
        head = new Node ();
        champion = null;
        
    }

    // I think a Binary Tree would be a good data structure to use for a tournament bracket, and would be good brownies points for using a variety of data structures.
    public class Node {
        Game game;
        Node parent;
        Node left;
        Node right;

        Node () {
            this.game = null;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        Node (Node parent) {
            this.game = null;
            this.parent = parent;
            this.left = null; 
            this.right = null;
        }

        Node (Node left, Node right) {
            this.game = null;
            this.parent = null;
            this.left = left;
            this.right = right;
        }

        Node (Game game, Node parent, Node left, Node right) {
            this.game = game;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    // FUNCTION: CREATE SINGLE ELIM
    // Creates a single elimination tournament bracket.
    protected Node createSingeElim (Team[] participants, int maxTeams) {
        if (Utils.powerOfTwo(maxTeams) == false) {
            System.out.println("Max teams must be a power of 2.");
            return null;
        } // for now, maybe only powers of 2 (2, 4, 8, 16, 32);

        Node head = new Node ();
        
        int depth = 1;
        fillOutBracket(participants, head, maxTeams, depth);
        
        int rights = 0;
        setBracket(participants, head, rights);

        return head;
    }

    // FUNCITON: FILL OUT BRACKET
    // Recursive function that creates the appropriate amount of nodes depending on how many teams are in the tournament.
    protected void fillOutBracket (Team[] pool, Node head, int maxTeams, int depth) {

        if (depth == (maxTeams / 4)) {
            return;
        }

        Node child1 = new Node(head);
        Node child2 = new Node(head);

        head.left = child1;
        head.right = child2;

        depth++;
        fillOutBracket(pool, child1, maxTeams, depth);
        fillOutBracket(pool, child2, maxTeams, depth);
    }

    // FUNCTION: SET BRACKET
    // Recursive function that fills out the initial state of the tournaments with teams in the leaf nodes.
    protected void setBracket (Team[] pool, Node head, int rights) {
        if (head == null) {
            return;
        }

        if (head.left == null && head.right == null) {
            head.game.participants[0] = pool[rights];
            head.game.participants[1] = pool[maxTeams - (rights + 1)];

            return;
        }

        setBracket(pool, head.left, rights);
        setBracket(pool, head.right, (rights+1));
    }

    // FUNCTION: UPDATE STANDINGS
    // Goes through the bracket and moves teams that have won to the next round.
    protected void updateStandings (Node root) {
        if (root == null) {
            return;
        }
        if (root.game.played) {
            if (root.equals(this.head)) { // if the game is the championship and it's been played, assign the champion.
                if (root.game.score[0] > root.game.score[1]) {
                    champion = root.game.participants[0];
                } else if (root.game.score[0] < root.game.score[1]) {
                    champion = root.game.participants[1];
                }
                return;
            }
            proceed(root); // moves team that has won a game into the next round.
            return;
        }

        // if the method makes it here, the game hasn't been played, so it checks the next round for played games.
        updateStandings(root.left); 
        updateStandings(root.right);
    }

    // FUNCTION: PROCEED
    // If a game is played, assigns team that won to the next round of the tournament.
    protected void proceed (Node head) {
        if (head.game.played) {
            if (head.game.score[0] > head.game.score[1]) {
                if (head.parent.left == head) {
                    head.parent.game.participants[0] = head.game.participants[0];
                } else if (head.parent.right == head) {
                    head.parent.game.participants[1] = head.game.participants[0]; 
                }
            } else if (head.game.score[1] > head.game.score[0]) {
                if (head.parent.left == head) {
                    head.parent.game.participants[0] = head.game.participants[1];
                } else if (head.parent.right == head) {
                    head.parent.game.participants[1] = head.game.participants[1]; 
                }
            }
        }    
    }


}
