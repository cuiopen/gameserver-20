package com.game.module.serial;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.game.module.attach.arena.ArenaPlayer;
import com.game.module.attach.training.TrainOpponent;
import com.game.module.copy.CopyRank;
import com.game.module.gang.GangDungeon;
import com.game.module.ladder.Ladder;
import com.game.module.mail.Mail;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * 全局的序列化数据
 */
public class SerialData {

    private boolean initArena;
    private boolean initRobot;
    private long trainingReset;
    private Map<Integer, TrainOpponent> opponents = new ConcurrentHashMap<Integer, TrainOpponent>();
    private Map<Integer, List<Integer>> sectionOpponents = new ConcurrentHashMap<Integer, List<Integer>>();
    private ConcurrentHashMap<Integer, ArenaPlayer> ranks = new ConcurrentHashMap<Integer, ArenaPlayer>();
    private ConcurrentHashMap<Integer, ArenaPlayer> playerRanks = new ConcurrentHashMap<Integer, ArenaPlayer>();
    private ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> friendRequests = new ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>>();
    private ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> friendSendRequests = new ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>>();
    private ConcurrentHashMap<Integer, CopyRank> copyRanks = new ConcurrentHashMap<Integer, CopyRank>();

    // 玩家刷出的商品数据<商店类型,<玩家id,[商品id]>
    private ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, List<Integer>>> playerRefreshShops = new ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, List<Integer>>>();
    //排位赛
    private Map<Integer, Ladder> ladderMap = new ConcurrentHashMap<>();
    //公会BOSS
    private Map<Integer, GangDungeon> gangMap = new ConcurrentHashMap<>();
    //公会重置时间
    private long gangDailyReset = 0L;

    //玩家相关数据最高排名缓存
    private Map<Integer, PlayerView> playerViews = new ConcurrentHashMap<>();
    //全局邮件
    private Map<Long, Mail> globalMail = new ConcurrentHashMap<>();
    private Map<Integer, Integer> bossKillTimes = new ConcurrentHashMap<>();
    private Set<Integer> cdkSet = Sets.newHashSet();

    public SerialData() {

    }

    public Map<Long, Mail> getGlobalMail() {
        return globalMail;
    }

    public void setGlobalMail(Map<Long, Mail> globalMail) {
        this.globalMail = globalMail;
    }

    public Set<Integer> getCdkSet() {
        return cdkSet;
    }

    public void setCdkSet(Set<Integer> cdkSet) {
        this.cdkSet = cdkSet;
    }

    public Map<Integer, Integer> getBossKillTimes() {
        return bossKillTimes;
    }

    public void setBossKillTimes(Map<Integer, Integer> bossKillTimes) {
        this.bossKillTimes = bossKillTimes;
    }

    public Map<Integer, PlayerView> getPlayerViews() {
        return playerViews;
    }

    public void setPlayerViews(Map<Integer, PlayerView> playerViews) {
        this.playerViews = playerViews;
    }

    public PlayerView getPlayerView(int playerId) {
        PlayerView view = playerViews.get(playerId);
        if (view == null) {
            view = new PlayerView();
            playerViews.put(playerId, view);
        }
        return view;
    }

    public Map<Integer, GangDungeon> getGangMap() {
        return gangMap;
    }

    public void setGangMap(Map<Integer, GangDungeon> gangMap) {
        this.gangMap = gangMap;
    }

    public ConcurrentHashMap<Integer, ArenaPlayer> getRanks() {
        return ranks;
    }

    public void setRanks(ConcurrentHashMap<Integer, ArenaPlayer> ranks) {
        this.ranks = ranks;
    }

    public ConcurrentHashMap<Integer, ArenaPlayer> getPlayerRanks() {
        return playerRanks;
    }

    public void setPlayerRanks(ConcurrentHashMap<Integer, ArenaPlayer> playerRanks) {
        this.playerRanks = playerRanks;
    }

    public boolean getInitArena() {
        return initArena;
    }

    public void setInitArena(boolean initArena) {
        this.initArena = initArena;
    }

    public boolean isInitRobot() {
        return initRobot;
    }

    public void setInitRobot(boolean initRobot) {
        this.initRobot = initRobot;
    }

    public long getTrainingReset() {
        return trainingReset;
    }

    public void setTrainingReset(long trainingReset) {
        this.trainingReset = trainingReset;
    }

    public ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> getFriendRequests() {
        return friendRequests;
    }

    public void setFriendRequests(ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> friendRequests) {
        this.friendRequests = friendRequests;
    }

    public ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> getFriendSendRequests() {
        return friendSendRequests;
    }

    public void setFriendSendRequests(ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, Boolean>> friendSendRequests) {
        this.friendSendRequests = friendSendRequests;
    }

    public ConcurrentHashMap<Integer, CopyRank> getCopyRanks() {
        return copyRanks;
    }

    public void setCopyRanks(ConcurrentHashMap<Integer, CopyRank> copyRanks) {
        this.copyRanks = copyRanks;
    }

    public ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, List<Integer>>> getPlayerRefreshShops() {
        return playerRefreshShops;
    }

    public void setPlayerRefreshShops(
            ConcurrentHashMap<Integer, ConcurrentHashMap<Integer, List<Integer>>> playerRefreshShops) {
        this.playerRefreshShops = playerRefreshShops;
    }

    public long getGangDailyReset() {
        return gangDailyReset;
    }

    public void setGangDailyReset(long gangDailyReset) {
        this.gangDailyReset = gangDailyReset;
    }

    public Map<Integer, TrainOpponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(Map<Integer, TrainOpponent> opponents) {
        this.opponents = opponents;
    }

    public Map<Integer, List<Integer>> getSectionOpponents() {
        return sectionOpponents;
    }

    public void setSectionOpponents(Map<Integer, List<Integer>> sectionOpponents) {
        this.sectionOpponents = sectionOpponents;
    }

    public Map<Integer, Ladder> getLadderMap() {
        return ladderMap;
    }

    public void setLadderMap(Map<Integer, Ladder> ladderMap) {
        this.ladderMap = ladderMap;
    }
}
