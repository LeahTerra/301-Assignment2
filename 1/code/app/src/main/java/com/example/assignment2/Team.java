package com.example.assignment2;

import java.util.ArrayList;

//--------------------------------------------------------------------------------------------------
// The team class is responsible for managing the members of the team
// Its responsibilities include creating and removing members, as well as returning the team list
//
// | Team()
// |\ createMember(name): Creates a new member and adds to the list
// |\ removeMember(name): Removes member from list
// |\ getMember(name): Gets member object with specified name
// |\ returnMembers(): Returns all members in team
//
//--------------------------------------------------------------------------------------------------

public class Team {

    private ArrayList<Member> members;

    public Team() {
        members = new ArrayList<>();
    }

    public void createMember(String name) {
        Member newMem = new Member(name);
        members.add(newMem);
    }

    public void removeMember(Member remMember) {
        this.members.remove(remMember);
    }

    public Member getMember(String name) {
        for(int i = 0; i < this.members.size(); i++) {
            if(this.members.get(i).getName() == name) {
                return this.members.get(i);
            }
        }
        return null;
    }

    public ArrayList<Member> returnMembers() {
        return this.members;
    }
}
