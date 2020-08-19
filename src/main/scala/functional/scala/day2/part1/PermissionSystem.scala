package functional.scala.day2.part1

import scalaz.Monoid
import scalaz._
import Scalaz._

object PermissionSystem {
  //
  // EXERCISE 11
  //
  // Design a permission system for securing some resource. Design the core
  // permissions data type, implement a monoid for the instance, and implement
  // the missing methods for the data type.
  //
  // Assumptions:
  //   1. Users have multiple accounts (`AccountID`)
  //   2. Each account gives different capabilities (`Capability`) to
  //      different resources (`ResourceID`)
  //
  type AccountID = String
  type ResourceID = String

  sealed trait Capability

  object Capability {

    final case object Read extends Capability

    final case object Write extends Capability

  }

  case class UserPermission(value: Map[AccountID, List[(ResourceID, Capability)]]) {
    /**
     * Provides the set of all resources the user has access to.
     */
    def allResources: Set[ResourceID] = value.values.flatMap(_.map(_._1)).toSet[ResourceID]

    /**
     * Provides the set of all capabilities the user has on the
     * specified resource.
     */
    def capabilitiesFor(resourceID: ResourceID): Set[Capability] =
      value.values.flatMap(_.filter(_._1 == resourceID).map(_._2)).toSet[Capability]

    /**
     * Determines which accounts give the user access to the specified
     * capability on the specified resource.
     */
    //def audit(resourceID: ResourceID, capability: Capability): Set[AccountID] = ???
  }


}
