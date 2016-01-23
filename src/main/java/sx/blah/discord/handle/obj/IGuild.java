package sx.blah.discord.handle.obj;

import sx.blah.discord.api.DiscordException;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.MissingPermissionsException;
import sx.blah.discord.util.HTTP429Exception;

import java.util.List;
import java.util.Optional;

/**
 * This class defines a guild/server/clan/whatever it's called.
 */
public interface IGuild {
	
	/**
	 * Gets the user id for the owner of this guild.
	 *
	 * @return The owner id.
	 */
	String getOwnerID();
	
	/**
	 * Gets the user object for the owner of this guild.
	 *
	 * @return The owner.
	 */
	IUser getOwner();
	
	/**
	 * Gets the icon id for this guild.
	 *
	 * @return The icon id.
	 */
	String getIcon();
	
	/**
	 * Gets the direct link to the guild's icon.
	 *
	 * @return The icon url.
	 */
	String getIconURL();
	
	/**
	 * Gets all the channels on the server.
	 *
	 * @return All channels on the server.
	 */
	List<IChannel> getChannels();
	
	/**
	 * Gets a channel on the guild by a specific channel id.
	 *
	 * @param id The ID of the channel you want to find.
	 * @return The channel with given ID.
	 */
	IChannel getChannelByID(String id);
	
	/**
	 * Gets all the users connected to the guild.
	 *
	 * @return All users connected to the guild.
	 */
	List<IUser> getUsers();
	
	/**
	 * Gets a user by its id in the guild.
	 *
	 * @param id ID of the user you want to find.
	 * @return The user with given ID.
	 */
	IUser getUserByID(String id);
	
	/**
	 * Gets the name of the guild.
	 *
	 * @return The name of the guild
	 */
	String getName();
	
	/**
	 * Gets the id of the guild.
	 *
	 * @return The ID of this guild.
	 */
	String getID();
	
	/**
	 * Gets the roles contained in this guild.
	 *
	 * @return The list of roles in the guild.
	 */
	List<IRole> getRoles();
	
	/**
	 * Gets a role object for its unique id.
	 *
	 * @param id The role id of the desired role.
	 * @return The role, or null if not found.
	 */
	IRole getRoleForID(String id);
	
	/**
	 * Gets the voice channels in this guild.
	 * 
	 * @return The voice channels.
	 */
	List<IVoiceChannel> getVoiceChannels();
	
	/**
	 * Gets a voice channel for a give id.
	 * 
	 * @param id The channel id.
	 * @return The voice channel (or null if not found).
	 */
	IVoiceChannel getVoiceChannelForID(String id);
	
	/**
	 * Gets the channel where afk users are placed.
	 * 
	 * @return The voice channel (or null if nonexistant).
	 */
	IVoiceChannel getAFKChannel();
	
	/**
	 * Gets the timeout (in seconds) before a user is placed in the AFK channel.
	 * 
	 * @return The timeout.
	 */
	int getAFKTimeout();
	
	/**
	 * Creates a new role in this guild.
	 * 
	 * @return The new role.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	IRole createRole() throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Retrieves the list of banned users from this guild.
	 * 
	 * @return The list of banned users.
	 * 
	 * @throws HTTP429Exception
	 */
	List<IUser> getBannedUsers() throws HTTP429Exception;
	
	/**
	 * Bans a user from this guild.
	 * 
	 * @param userID The user to ban.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void banUser(String userID) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Bans a user from this guild.
	 *
	 * @param userID The user to ban.
	 * @param deleteMessagesForDays The number of days to delete messages from this user for.
	 *
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void banUser(String userID, int deleteMessagesForDays) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * This removes a ban on a user.
	 * 
	 * @param userID The user to unban.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void pardonUser(String userID) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Kicks a user from the guild.
	 * 
	 * @param userID The user to kick.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void kickUser(String userID) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Edits the roles a user is a part of.
	 * 
	 * @param userID The user to edit the roles for.
	 * @param roleIDs The roles for the user to have.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void editUserRoles(String userID, String[] roleIDs) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Edits the guild.
	 * 
	 * @param name The name of the guild.
	 * @param regionID The region id for the guild.
	 * @param icon The icon for the guild.
	 * @param afkChannelID The afk channel for the guild. NOTE: if not present there will be no afk channel.
	 * @param afkTimeout The afk timeout for the guild.
	 * 
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	void edit(Optional<String> name, Optional<String> regionID, Optional<IDiscordClient.Image> icon, Optional<String> afkChannelID, Optional<Integer> afkTimeout) throws MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Deletes the channel if you are its owner or leaves it if not.
	 * 
	 * @throws HTTP429Exception
	 */
	void deleteOrLeaveGuild() throws HTTP429Exception;
	
	/**
	 * Creates a new channel.
	 *
	 * @param name The name of the new channel. MUST be between 2-100 characters long.
	 * @return The new channel.
	 *
	 * @throws DiscordException
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	IChannel createChannel(String name) throws DiscordException, MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Creates a new voice channel.
	 *
	 * @param name The name of the new channel. MUST be between 2-100 characters long.
	 * @return The new channel.
	 *
	 * @throws DiscordException
	 * @throws MissingPermissionsException
	 * @throws HTTP429Exception
	 */
	IVoiceChannel createVoiceChannel(String name) throws DiscordException, MissingPermissionsException, HTTP429Exception;
	
	/**
	 * Gets the region this guild is located in.
	 * 
	 * @return The region.
	 */
	IRegion getRegion();
	
	/**
	 * Transfers the ownership of this guild to another user.
	 * 
	 * @param newOwnerID The new owner's user id.
	 * 
	 * @throws HTTP429Exception
	 * @throws MissingPermissionsException
	 */
	void transferOwnership(String newOwnerID) throws HTTP429Exception, MissingPermissionsException;
}
