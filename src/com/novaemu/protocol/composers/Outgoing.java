package com.novaemu.protocol.composers;

public class Outgoing
{
	public static int SecretKeyEvent = 1;
    public static int InitCryptoMessageEvent = 277;
    public static int SessionParamsMessageEvent = 257;
    public static int UserRightsMessageEvent = 2;
    public static int AuthenticationOKMessageEvent = 3;
    public static int PingMessageEvent = 50;
    public static int UserObjectEvent = 5;
    public static int UniqueMachineIDEvent = 439;
    public static int GenericErrorEvent = 33;
    public static int DisconnectReasonEvent = 287;
    public static int IdentityAccountsEvent = 626;
    public static int AvailabilityStatusMessageEvent = 290;
    public static int InfoHotelClosingMessageEvent = 291;
    public static int InfoHotelClosedMessageEvent = 292;
    public static int AvailabilityTimeMessageEvent = 293;
    public static int LoginFailedHotelClosedMessageEvent = 294;
    public static int MessengerInitEvent = 12;
    public static int NewBuddyRequestEvent = 132;
    public static int NewConsoleMessageEvent = 134;
    public static int MessengerErrorEvent = 260;
    public static int InstantMessageErrorEvent = 261;
    public static int BuddyRequestsEvent = 314;
    public static int AcceptBuddyResultEvent = 315;
    public static int FriendListUpdateEvent = 13;
    public static int HabboSearchResultEvent = 435;
    public static int FollowFriendFailedEvent = 349;
    public static int RoomInviteErrorEvent = 262;
    public static int RoomInviteEvent = 135;
    public static int FindFriendsProcessResultEvent = 831;
    public static int FriendNotificationEvent = 833;
    public static int EventStreamEvent = 950;
    public static int CreditBalanceEvent = 6;
    public static int FurniListInsertEvent = 98;
    public static int FurniListRemoveEvent = 99;
    public static int FurniListUpdateEvent = 101;
    public static int FurniListEvent = 140;
    public static int PostItPlacedEvent = 145;
    public static int AvatarEffectsMessageEvent = 460;
    public static int AvatarEffectAddedMessageEvent = 461;
    public static int AvatarEffectActivatedMessageEvent = 462;
    public static int AvatarEffectExpiredMessageEvent = 463;
    public static int AvatarEffectSelectedMessageEvent = 464;
    public static int BadgesEvent = 229;
    public static int BadgePointLimitsEvent = 627;
    public static int AchievementsEvent = 436;
    public static int AchievementsScoreEvent = 443;
    public static int AchievementEvent = 913;
    public static int TradingYouAreNotAllowedEvent = 102;
    public static int TradingOtherNotAllowedEvent = 103;
    public static int TradingOpenEvent = 104;
    public static int TradingAlreadyOpenEvent = 105;
    public static int TradingNotOpenEvent = 106;
    public static int TradingNoSuchItemEvent = 107;
    public static int TradingItemListEvent = 108;
    public static int TradingAcceptEvent = 109;
    public static int TradingCloseEvent = 110;
    public static int TradingConfirmationEvent = 111;
    public static int TradingCompletedEvent = 112;
    public static int PetInventoryEvent = 600;
    public static int PetAddedToInventoryEvent = 603;
    public static int PetRemovedFromInventoryEvent = 604;
    public static int PetReceivedMessageEvent = 607;
    public static int MarketplaceMakeOfferResult = 610;
    public static int MarketplaceCanMakeOfferResult = 611;
    public static int MarketplaceConfigurationEvent = 612;
    public static int MarketplaceBuyOfferResultEvent = 613;
    public static int MarketplaceCancelOfferResultEvent = 614;
    public static int MarketPlaceOffersEvent = 615;
    public static int MarketPlaceOwnOffersEvent = 616;
    public static int MarketplaceItemStatsEvent = 617;
    public static int UserFlatCatsEvent = 221;
    public static int FlatCatEvent = 222;
    public static int CanCreateRoomEventEvent = 367;
    public static int RoomEventEvent = 370;
    public static int DoorbellMessageEvent = 91;
    public static int FlatAccessDeniedMessageEvent = 131;
    public static int RoomSettingsDataEvent = 465;
    public static int RoomSettingsErrorEvent = 466;
    public static int RoomSettingsSavedEvent = 467;
    public static int RoomSettingsSaveErrorEvent = 468;
    public static int NoSuchFlatEvent = 44;
    public static int OfficialRoomsEvent = 450;
    public static int GuestRoomSearchResultEvent = 451;
    public static int PopularRoomTagsResultEvent = 452;
    public static int PublicSpaceCastLibsEvent = 453;
    public static int GetGuestRoomResultEvent = 454;
    public static int NavigatorSettingsEvent = 455;
    public static int RoomInfoUpdatedEvent = 456;
    public static int RoomThumbnailUpdateResultEvent = 457;
    public static int FavouritesEvent = 458;
    public static int FavouriteChangedEvent = 459;
    public static int FlatCreatedEvent = 59;
    public static int RoomRatingEvent = 345;
    public static int FlatControllerAddedEvent = 510;
    public static int FlatControllerRemovedEvent = 511;
    public static int CanCreateRoomEvent = 512;
    public static int CloseConnectionMessageEvent = 18;
    public static int OpenConnectionMessageEvent = 19;
    public static int RoomQueueStatusMessageEvent = 259;
    public static int RoomForwardMessageEvent = 286;
    public static int ChatMessageEvent = 24;
    public static int WhisperMessageEvent = 25;
    public static int ShoutMessageEvent = 26;
    public static int UserTypingMessageEvent = 361;
    public static int FloodControlMessageEvent = 27;
    public static int FlatAccessibleMessageEvent = 41;
    public static int RoomReadyMessageEvent = 69;
    public static int UsersMessageEvent = 28;
    public static int UserRemoveMessageEvent = 29;
    public static int HeightMapMessageEvent = 31;
    public static int ObjectsMessageEvent = 32;
    public static int UserUpdateMessageEvent = 34;
    public static int ItemsMessageEvent = 45;
    public static int ItemDataUpdateMessageEvent = 48;
    public static int ItemAddMessageEvent = 83;
    public static int ItemRemoveMessageEvent = 84;
    public static int ItemUpdateMessageEvent = 85;
    public static int ObjectAddMessageEvent = 93;
    public static int ViralTeaserActiveMessageEvent = 805;
    public static int ObjectDataUpdateMessageEvent = 88;
    public static int ObjectRemoveMessageEvent = 94;
    public static int ObjectUpdateMessageEvent = 95;
    public static int PetInfoMessageEvent = 210;
    public static int HeightMapUpdateMessageEvent = 219;
    public static int SlideObjectBundleMessageEvent = 230;
    public static int YouAreSpectatorMessageEvent = 254;
    public static int UserChangeMessageEvent = 266;
    public static int RoomDimmerPresetsMessageEvent = 365;
    public static int FloorHeightMapMessageEvent = 470;
    public static int RoomEntryInfoMessageEvent = 471;
    public static int RoomVisualizationSettingsEvent = 472;
    public static int ObjectsDataUpdateMessageEvent = 473;
    public static int PlaceObjectErrorMessageEvent = 516;
    public static int UserNameChangedMessageEvent = 572;
    public static int ViralFurniGiftReceivedEvent = 806;
    public static int ViralFurniStatusEvent = 807;
    public static int UserNotificationMessageEvent = 808;
    public static int WelcomeGiftStatusEvent = 829;
    public static int FurnitureAliasesMessageEvent = 297;
    public static int RoomPropertyMessageEvent = 46;
    public static int YouAreControllerMessageEvent = 42;
    public static int YouAreNotControllerMessageEvent = 43;
    public static int YouAreOwnerMessageEvent = 47;
    public static int RequestSpamWallPostItMessageEvent = 911;
    public static int RoomMessageNotificationMessageEvent = 912;
    public static int CantConnectMessageEvent = 224;
    public static int PetInfoMessageEvent2 = 601;
    public static int PetCommandsMessageEvent = 605;
    public static int PetPlacingErrorEvent = 608;
    public static int PetExperienceEvent = 609;
    public static int PetRespectFailedEvent = 621;
    public static int DanceMessageEvent = 480;
    public static int WaveMessageEvent = 481;
    public static int CarryObjectMessageEvent = 482;
    public static int AvatarEffectMessageEvent = 485;
    public static int SleepMessageEvent = 486;
    public static int UseObjectMessageEvent = 488;
    public static int DiceValueMessageEvent = 90;
    public static int PresentOpenedMessageEvent = 129;
    public static int OpenPetPackageRequestedMessageEvent = 825;
    public static int OpenPetPackageResultMessageEvent = 826;
    public static int OneWayDoorStatusMessageEvent = 312;
    public static int PublicRoomObjectsMessageEvent = 30;
    public static int DoorOtherEndDeletedMessageEvent = 63;
    public static int DoorNotInstalledMessageEvent = 64;
    public static int UserTagsMessageEvent = 350;
    public static int HabboUserBadgesMessageEvent = 228;
    public static int HabboGroupBadgesMessageEvent = 309;
    public static int FavoriteMembershipUpdateMessageEvent = 310;
    public static int HabboGroupDetailsMessageEvent = 311;
    public static int HabboGroupsWhereMemberMessageEvent = 915;
    public static int HabboGroupJoinFailedMessageEvent = 916;
    public static int IgnoreResultMessageEvent = 419;
    public static int IgnoredUsersMessageEvent = 420;
    public static int RespectNotificationMessageEvent = 440;
    public static int PetRespectNotificationEvent = 606;
    public static int UserBannedMessageEvent = 35;
    public static int ModMessageEvent = 161;
    public static int IssueDeletedMessageEvent = 273;
    public static int IssueInfoMessageEvent = 530;
    public static int ModeratorInitMessageEvent = 531;
    public static int IssuePickFailedMessageEvent = 532;
    public static int ModeratorUserInfoEvent = 533;
    public static int CfhChatlogEvent = 534;
    public static int RoomChatlogEvent = 535;
    public static int UserChatlogEvent = 536;
    public static int RoomVisitsEvent = 537;
    public static int ModeratorRoomInfoEvent = 538;
    public static int ModeratorActionResultMessageEvent = 539;
    public static int CallForHelpReplyMessageEvent = 274;
    public static int CallForHelpPendingCallsMessageEvent = 319;
    public static int CallForHelpPendingCallsDeletedMessageEvent = 320;
    public static int CallForHelpResultMessageEvent = 321;
    public static int FaqClientFaqsMessageEvent = 518;
    public static int FaqCategoriesMessageEvent = 519;
    public static int FaqTextMessageEvent = 520;
    public static int FaqSearchResultsMessageEvent = 521;
    public static int FaqCategoryMessageEvent = 522;
    public static int IssueCloseNotificationMessageEvent = 540;
    public static int TutorialStatusMessageEvent = 575;
    public static int HotelMergeNameChangeEvent = 573;
    public static int ErrorReportEvent = 299;
    public static int ChangeEmailResultEvent = 830;
    public static int ScrSendUserInfoEvent = 7;
    public static int HabboBroadcastMessageEvent = 139;
    public static int ClubGiftNotificationEvent = 280;
    public static int HabboAchievementNotificationMessageEvent = 437;
    public static int HabboAchievementBonusMessageEvent = 445;
    public static int HabboAchievementShareIdMessageEvent = 444;
    public static int HabboActivityPointNotificationMessageEvent = 438;
    public static int ActivityPointsMessageEvent = 628;
    public static int InfoFeedEnableMessageEvent = 517;
    public static int PetLevelNotificationEvent = 602;
    public static int MOTDNotificationEvent = 810;
    public static int UnseenItemsEvent = 832;
    public static int CatalogIndexMessageEvent = 126;
    public static int CatalogPageMessageEvent = 127;
    public static int PurchaseErrorMessageEvent = 65;
    public static int PurchaseOKMessageEvent = 67;
    public static int NotEnoughBalanceMessageEvent = 68;
    public static int GiftReceiverNotFoundEvent = 76;
    public static int PurchaseNotAllowedMessageEvent = 296;
    public static int CatalogPublishedMessageEvent = 441;
    public static int VoucherRedeemOkMessageEvent = 212;
    public static int VoucherRedeemErrorMessageEvent = 213;
    public static int GiftWrappingConfigurationEvent = 620;
    public static int IsOfferGiftableMessageEvent = 622;
    public static int ClubGiftInfoEvent = 623;
    public static int ClubGiftSelectedEvent = 624;
    public static int HabboClubOffersMessageEvent = 625;
    public static int ChargeInfoMessageEvent = 629;
    public static int SellablePetBreedsMessageEvent = 827;
    public static int HabboClubExtendOfferMessageEvent = 630;
    public static int RecyclerPrizesMessageEvent = 506;
    public static int RecyclerStatusMessageEvent = 507;
    public static int RecyclerFinishedMessageEvent = 508;
    public static int RoomAdMessageEvent = 208;
    public static int InterstitialMessageEvent = 258;
    public static int LatencyPingResponseMessageEvent = 354;
    public static int VoteQuestionMessageEvent = 79;
    public static int VoteResultMessageEvent = 80;
    public static int PollOfferEvent = 316;
    public static int PollContentsEvent = 317;
    public static int PollErrorEvent = 318;
    public static int ParkBusCannotEnterMessageEvent = 81;
    public static int ParkBusDoorMessageEvent = 503;
    public static int OpenLockerRoomMessageEvent = 96;
    public static int ApproveNameMessageEvent = 36;
    public static int SoundSettingsEvent = 308;
    public static int TraxSongInfoMessageEvent = 300;
    public static int PlayListMessageEvent = 323;
    public static int UserSongDisksInventoryMessageEvent = 333;
    public static int JukeboxSongDisksMessageEvent = 334;
    public static int PlayListSongAddedMessageEvent = 335;
    public static int NowPlayingMessageEvent = 327;
    public static int JukeboxPlayListFullMessageEvent = 337;
    public static int WardrobeMessageEvent = 267;
    public static int ChangeUserNameResultMessageEvent = 570;
    public static int CheckUserNameResultMessageEvent = 571;
    public static int WiredFurniTriggerEvent = 650;
    public static int WiredFurniActionEvent = 651;
    public static int WiredFurniConditionEvent = 652;
    public static int OpenEvent = 653;
    public static int YouArePlayingGameMessageEvent = 700;
    public static int GamePlayerValueMessageEvent = 701;
    public static int QuestsMessageEvent = 800;
    public static int QuestCompletedMessageEvent = 801;
    public static int QuestMessageEvent = 802;
    public static int QuestsMessageEvent2 = 803;
    public static int FaceBookAuthenticateEvent = 901;
    public static int FaceBookErrorEvent = 902;
    public static int FaceBookAppRequestEvent = 910;
    public static int CameraSnapshotMessageEvent = 1000;
}
