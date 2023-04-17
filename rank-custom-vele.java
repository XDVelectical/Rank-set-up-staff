public enum Rank {
    ADMIN(ChatColor.LIGHT_PURPLE + "Admin"),
    DEV(ChatColor.AQUA + "DEV"),
    MOD(ChatColor.GREEN + "MOD"),
    NONE(ChatColor.WHITE + "Member");

    private final String prefix;
    Rank(String prefix) {
        this.prefix = prefix;
    }
}

Map<Player, Rank> ranks = new HashMap<>();

public void setRank(Player player, Rank rank) {
     ranks.put(player, rank);
}

public Rank getRank(Player player) {
     return ranks.get(player);
}

public void loadRank(Player player) {
    String rankString = getConfig().get(player.getUniqueId() + ".rank");
    Rank rank = (rankString == null) ? Rank.NONE : Rank.valueOf(rankString);
    player.setDisplayName(prefix.get(rank) + player.getName());
    player.setPlayerListName(prefix.get(rank) + player.getName());
    ranks.put(player, rank);
}
public void saveRank(Player player) {
    getConfig().set(player.getUniqueId() + ".rank", ranks.get(rank));
    ranks.remove(player);
}

if (getRank(player) == Rank.ADMIN) {
     player.setWalkSpeed(0.4F);
} else {
     player.setWalkSpeed(0.2F);
}
