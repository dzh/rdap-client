package rdap.client;

/**
 * RDAP JSON Values
 *
 * @author dzh
 * @date 2019-03-27 20:04
 */
interface RdapValue {

    /********************* notice and remark type https://tools.ietf.org/html/rfc7483#section-10.2.1   **********************/
    String NOTICE_result_set_truncated_due_to_authorization = "result set truncated due to authorization";
    String NOTICE_result_set_truncated_due_to_excessive_load = "result set truncated due to excessive load";
    String NOTICE_result_set_truncated_due_to_unexplainable_reasons = "result set truncated due to unexplainable reasons";
    String NOTICE_object_truncated_due_to_authorization = "object truncated due to authorization";
    String NOTICE_object_truncated_due_to_excessive_load = "object truncated due to excessive load";
    String NOTICE_object_truncated_due_to_unexplainable_reasons = "object truncated due to unexplainable reasons";


    /********************* status https://tools.ietf.org/html/rfc7483#section-10.2.2   **********************/
    String STATUS_validated = "validated";
    String STATUS_renew_prohibited = "renew prohibited";
    String STATUS_update_prohibited = "update prohibited";
    String STATUS_transfer_prohibited = "transfer prohibited";
    String STATUS_delete_prohibited = "delete prohibited";
    String STATUS_proxy = "proxy";
    String STATUS_private = "private";
    String STATUS_removed = "removed";
    String STATUS_obscured = "obscured";
    String STATUS_associated = "associated";
    String STATUS_active = "active";
    String STATUS_inactive = "inactive";
    String STATUS_locked = "locked";
    String STATUS_pending_create = "pending create";
    String STATUS_pending_renew = "pending renew";
    String STATUS_pending_transfer = "pending transfer";
    String STATUS_pending_update = "pending update";
    String STATUS_pending_delete = "pending delete";

    /********************* Event Actions https://tools.ietf.org/html/rfc7483#section-10.2.3   **********************/
    String EVENT_registration = "registration";
    String EVENT_reregistration = "reregistration";
    String EVENT_last_changed = "last changed";
    String EVENT_expiration = "expiration";
    String EVENT_deletion = "deletion";
    String EVENT_reinstantiation = "reinstantiation";
    String EVENT_transfer = "transfer";
    String EVENT_locked = "locked";
    String EVENT_unlocked = "unlocked";

    /********************* Roles https://tools.ietf.org/html/rfc7483#section-10.2.4   **********************/
    /**
     * Value: registrant
     * Type: role
     * Description: The entity object instance is the registrant of the
     * registration.  In some registries, this is known as a
     * maintainer.
     * Registrant Name: IESG
     * Registrant Contact Information: iesg@ietf.org
     */
    String ROLE_registrant = "registrant";
    String ROLE_technical = "technical";
    String ROLE_administrative = "administrative";
    /**
     * Value: abuse
     * Type: role
     * Description: The entity object instance handles network abuse
     * issues on behalf of the registrant of the registration.
     * Registrant Name: IESG
     * Registrant Contact Information: iesg@ietf.org
     */
    String ROLE_abuse = "abuse";
    String ROLE_billing = "billing";
    String ROLE_registrar = "registrar";
    String ROLE_reseller = "reseller";
    String ROLE_sponsor = "sponsor";
    String ROLE_proxy = "proxy";
    String ROLE_notifications = "notifications";
    /**
     * Value: noc
     * Type: role
     * Description: The entity object instance handles communications
     * related to a network operations center (NOC).
     * Registrant Name: IESG
     * Registrant Contact Information: iesg@ietf.org
     */
    String ROLE_noc = "noc";

    /********************* Variant Relations https://tools.ietf.org/html/rfc7483#section-10.2.5   **********************/
    String VARIANT_registered = "registered";
    String VARIANT_unregistered = "unregistered";
    String VARIANT_registration_restricted = "registration restricted";
    String VARIANT_open_registration = "open registration";
    String VARIANT_conjoined = "conjoined";

}
