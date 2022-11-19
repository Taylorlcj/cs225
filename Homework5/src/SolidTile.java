//***********************************************
// Class: GenericTile
// Author: Keith Garfield
// Created: October 16, 2022
// Modified:
//
// Attributes: -exits: boolean[4] - An array of length 4 [N, E, S, W], #f = locked, #t = unlocked
//             -description: String - a text description of the room.
//
// Methods: +enterAction: void - Performs an action when an agent enters
//          +exitAction: void - Performs an action when the agent exits
//          +specialAction: void - Performs an action randomly (probability tbd)
//
// Specialized setters and getters:
//          +setAllExitsValue( boolean ): void - Sets all exits to true or false.
//          +setAllExitsRandom(): void - sets all exits randomly (50/50 true or false)
//
//***********************************************
public class SolidTile extends GenericTile{
}
