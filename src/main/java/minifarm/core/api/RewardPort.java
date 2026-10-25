package minifarm.core.api;

/**
 * Port integrasi domain untuk pemberian reward (koin, item, atau XP) secara atomik.
 */
public interface RewardPort {
    OperationResult<Void> grantCoinReward(long coins);
    OperationResult<Void> grantItemReward(String itemId, int quantity);
    OperationResult<Void> grantXpReward(String skillCategory, int xp);
}

